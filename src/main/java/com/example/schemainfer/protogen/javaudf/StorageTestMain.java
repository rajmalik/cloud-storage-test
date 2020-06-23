package com.example.schemainfer.protogen.javaudf;

import com.example.schemainfer.protogen.utils.Constants;
import com.example.schemainfer.protogen.utils.GCSBlobWriter;
import com.google.api.gax.paging.Page;
import com.google.cloud.storage.*;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class StorageTestMain {
  //  private static final Logger LOG = LoggerFactory.getLogger(SeqFilesScan.class);

    public StorageTestMain() {
    }

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {

        String mode = getRunMode(args);
        authImplicit() ;
        testUsingAppEngineStorage("protos/gameevent.proto" ) ;
    }

    static void authImplicit() {
        // If you don't specify credentials when constructing the client, the client library will
        // look for credentials via the environment variable GOOGLE_APPLICATION_CREDENTIALS.
        Storage storage = StorageOptions.getDefaultInstance().getService();

        System.out.println("Buckets:");
        final Page<com.google.cloud.storage.Bucket> buckets = storage.list();
        for (Bucket bucket : buckets.iterateAll()) {
            System.out.println(bucket.toString());
        }
    }

    public static void testStorageApi()  {
        String newString = "Hello, World!";
        testUsingAppEngineStorage(newString);
        GCSBlobWriter testWriter = new GCSBlobWriter("protos/gameevent.proto");
    }

    private static void testUsingAppEngineStorage(String newString) {
        try {
            Storage storage = StorageOptions.getDefaultInstance().getService();
            byte[] bytes = newString.getBytes(Constants.UTF8_CHARSET);
            Blob blob = storage.get(BlobId.of("schema-inference-out", "protos/gameevent.proto"));
            System.out.println("1) Successful getting Storage ID: " + blob.toString()) ;

            WritableByteChannel channel = blob.writer();
            System.out.println("2) Successful getting WritableByteChannel :" + blob.toString()) ;
            channel.write(ByteBuffer.wrap(newString.getBytes(Constants.UTF8_CHARSET)));
            System.out.println("3) Successful writing TO hannel :" ) ;
            channel.close();
            System.out.println("4) Successful cloding hannel :" ) ;
        } catch (IOException ioc) {
            System.out.println("Got error-1 writing to storage: " + ioc.getMessage()) ;
        }
    }


    private static String getRunMode(String[] args) {
        String mode = Constants.RUN_MODE.Cluster.name() ;
        if (args != null && args.length > 0) {
            String argmode = args[0] ;
            if (!argmode.isEmpty()) {
                if (argmode.equalsIgnoreCase(Constants.RUN_MODE.Local.name())) {
                    mode = Constants.RUN_MODE.Local.name() ;
                }
            }
        }
        return mode;
    }


}
