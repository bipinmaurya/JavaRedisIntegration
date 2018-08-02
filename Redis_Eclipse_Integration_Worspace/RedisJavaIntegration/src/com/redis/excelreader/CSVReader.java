package com.redis.excelreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import redis.clients.jedis.Jedis;

public class CSVReader {

	public static void main(String[] args) {
		String csvFile = "C:\\Bipin\\BreakfastOye\\PIN Code\\All_India_pincode_data_26022018.csv";
		Jedis jredis = new Jedis("localhost");
        String line = "";
        String cvsSplitBy = ",";
        String pincode="", regionname="", circlename="",taluk="",districtname="",statename="";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	System.out.println("Start making redis insertion.");
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] pinDetail = line.split(cvsSplitBy);

                pincode=pinDetail[1];
                regionname = pinDetail[5];
                circlename = pinDetail[6];
                taluk = pinDetail[7];
                districtname = pinDetail[8];
                statename = pinDetail[9];
                String json= "{"+ "regionname:"+ regionname + ",circlename:"+circlename +",taluk:"+taluk + ",districtname:"+districtname +",statename:"+ statename+"}";
                jredis.hset("pincode",pincode, json);
                
            }
            System.out.println("Data inserted succesfully in redis db.");

        } catch (IOException e) {
            e.printStackTrace();
        }

	}

}
