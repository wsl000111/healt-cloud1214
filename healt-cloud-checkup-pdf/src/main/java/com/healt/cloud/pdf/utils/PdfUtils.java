package com.healt.cloud.pdf.utils;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liyongfei
 * @date 2022-09-01 8:59
 */

public class PdfUtils {

    /**
     * pdf合并拼接
     * @param files 文件列表
     * @param targetPath 合并到
     * @return
     * @throws IOException
     */
    public static File mulFile2One(List<File> files,String targetPath) throws IOException{
        // pdf合并工具类
        PDFMergerUtility mergePdf = new PDFMergerUtility();
        for (File f : files) {
            if(f.exists() && f.isFile()){
                // 循环添加要合并的pdf
                mergePdf.addSource(f);
            }
        }
        // 设置合并生成pdf文件名称
        mergePdf.setDestinationFileName(targetPath);
        // 合并pdf
        mergePdf.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
        return new File(targetPath);
    }

    public static void mulFile2One(List<InputStream> sourcesList, String targetPath, String fileName) throws IOException {
        PDFMergerUtility mergePdf = new PDFMergerUtility();
        mergePdf.addSources(sourcesList);
        System.out.println(targetPath+fileName);
        File file = new File(targetPath);
        if(!file.exists()){
            file.mkdirs();
        }
        // 设置合并生成pdf文件名称
        mergePdf.setDestinationFileName(targetPath+fileName);
        // 合并生成pdf文件
        mergePdf.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
    }

    /**
     * 从网络Url中下载文件
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static void downLoadByUrl(String urlStr,String fileName,String savePath) throws IOException{
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(5*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);
        //文件保存位置
        File saveDir = new File(savePath);
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
        File file = new File(saveDir+File.separator+fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if(fos!=null){
            fos.close();
        }
        if(inputStream!=null){
            inputStream.close();
        }
        System.out.println("info:"+url+" download success");

    }

    public static InputStream getInputStreamByUrl(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(5*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        //得到输入流
        InputStream inputStream = conn.getInputStream();
        return inputStream;
    }

    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    public static void main(String[] args) throws IOException {
        List<File> files = new ArrayList<File>();
        files.add(new File("D:\\test\\f1.pdf"));
        files.add(new File("D:\\test\\f2.pdf"));
        files.add(new File("D:\\test\\f3.pdf"));

        try{
            downLoadByUrl("http://www.leomay.com/upload/file/mmo-20170707165001.pdf",
                    "download.pdf","D:\\test");
        }catch (Exception e) {
            // TODO: handle exception
        }
        files.add(new File("D:\\test\\download.pdf"));

        File f = mulFile2One(files, "D:\\test\\mul2one2.pdf");
        System.out.println(f.length());

    }
}
