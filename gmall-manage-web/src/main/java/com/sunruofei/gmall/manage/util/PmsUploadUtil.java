package com.sunruofei.gmall.manage.util;

import org.apache.commons.lang3.StringUtils;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

public class PmsUploadUtil {

    public static String uploadImage(MultipartFile file) {

        String fileUrl = "http://192.168.101.128";
        String imgUrl = fileUrl;
        if (file != null) {
            try {
                System.out.println("multipartFile = " + file.getName() + "|" + file.getSize());

                ClientGlobal.initByProperties("tracker.properties");

                TrackerClient trackerClient = new TrackerClient();
                TrackerServer trackerServer = trackerClient.getTrackerServer();
                StorageClient storageClient = new StorageClient(trackerServer, null);
                String filename = file.getOriginalFilename();
                String extName = StringUtils.substringAfterLast(filename, ".");

                String[] upload_file = storageClient.upload_file(file.getBytes(), extName, null);
                imgUrl = fileUrl;
                for (int i = 0; i < upload_file.length; i++) {
                    String path = upload_file[i];
                    imgUrl += "/" + path;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        return imgUrl;
    }

}
