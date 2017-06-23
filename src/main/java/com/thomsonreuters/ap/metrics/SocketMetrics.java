package com.thomsonreuters.ap.metrics;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The SocketMetrics class, which is a implementation Metrics class for graphite.
 *
 */
public class SocketMetrics implements Metrics {
  public static final String DEFAULT_HOST = "10.194.232.101";//use xuefeng's vm for now
  public static final int DEFAULT_PORT = 2003;
  public static final int TIMEOUT = 2000;//ms
  
  private static final Logger LOG = LoggerFactory.getLogger(SocketMetrics.class);
  private final String host;
  private final int port;
  
  protected SocketMetrics(String host, int port) {
    this.host = host;
    this.port = port;
  }

  public void add(String metricPath, String metricsValue, long seconds) throws IOException {
    try (Socket socket = new Socket()){
      socket.connect(new InetSocketAddress(host, port), TIMEOUT);
      OutputStream output = socket.getOutputStream();
      PrintWriter writer = new PrintWriter(output);
      String data = String.format("%s %s %d", metricPath, metricsValue, seconds);
      writer.println(data);
      writer.flush();
      LOG.info(data);
    }
  }
}
