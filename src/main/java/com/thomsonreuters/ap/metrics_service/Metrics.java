package com.thomsonreuters.ap.metrics_service;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class Metrics {
  private static final String host = "10.194.232.101";
  private static final int port = 2003;
  
  private Metrics() {
  }
  
  public static void send(String metricPath, String metricsValue, long timestamp) {
    try {
      Socket socket = new Socket(host, port);
      System.err.println("Connecting to " + host + " port " + port);
      
      OutputStream output = socket.getOutputStream();
      PrintWriter writer = new PrintWriter(output);
      String data = String.format("%s %s %d", metricPath, metricsValue, timestamp/1000);
      writer.println(data);
      writer.flush();
      System.out.println(data);
      socket.close();
    } catch (IOException e) {
      System.err.println("send metrics data exception" + e);
    }
}

  public static void main(String[] args) {
    for(int i=0; i< 10; ++i) {
      Metrics.send("test.java.metrics", String.valueOf(100+i), System.currentTimeMillis() - (i * 60 * 60 * 1000));
    }
  }
}
