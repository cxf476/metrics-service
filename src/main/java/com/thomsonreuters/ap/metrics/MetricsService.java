package com.thomsonreuters.ap.metrics;

import java.io.IOException;

public class MetricsService {
  private MetricsService() {
  }

  public static Metrics getMetrics() throws IOException {
    return new SocketMetrics(SocketMetrics.DEFAULT_HOST, SocketMetrics.DEFAULT_PORT);
  }
  
  /**
   * This is mostly for unit test, so that user can specify ip and port
   * @param host
   * @param port
   * @return
   * @throws IOException
   */
  public static Metrics getMetrics(String host, int port) throws IOException {
    return new SocketMetrics(host, port);
  }
}
