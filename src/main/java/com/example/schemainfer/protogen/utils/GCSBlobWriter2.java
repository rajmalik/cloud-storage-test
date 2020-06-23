package com.example.schemainfer.protogen.utils;


import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class GCSBlobWriter2 {

  //  private static final Logger LOG = LoggerFactory.getLogger(GCSBlobWriter.class);


   //  WriteChannel writerChannel = null ;

   //  PrintWriter writer = null;
  //  Blob blob = null ;
    // Storage storage = StorageOptions.getDefaultInstance().getService();
    //Storage storage = StorageOptions.newBuilder()
    //        .setProjectId("rdp-data-platform-dev-f8e8").build().getService();
    // WritableByteChannel writechannel = null ;

    public GCSBlobWriter2(String relativePathtOGcsObject) {
//        System.out.println(" FIle in bucket: " + relativePathtOGcsObject) ;
//        try {
//           // useAppEngineClient(relativePathtOGcsObject);
//            useStorage(relativePathtOGcsObject) ;
//
//        } catch (Exception e) {
//            System.err.println("Error opening channel to GCS: " + e.getMessage());
//            e.printStackTrace();
//        }
    }

    private void useStorage(String relativePathtOGcsObject) throws IOException {

//        blob = storage.get(BlobId.of("schema-inference-out", relativePathtOGcsObject));
//        writerChannel = blob.writer();
//
//        String ss = "Hello";
//        final byte[] ssBytes = ss.getBytes(Constants.UTF8_ENCODING);
//        writerChannel.write(ByteBuffer.wrap(ssBytes));

    }



}
