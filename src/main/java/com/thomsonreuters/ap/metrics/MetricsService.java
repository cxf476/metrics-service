package com.thomsonreuters.ap.metrics;

public class MetricsService {
  private MetricsService() {
  }

  public static Metrics getMetrics() {
    return new SocketMetrics(SocketMetrics.DEFAULT_HOST, SocketMetrics.DEFAULT_PORT);
  }
  
  /**
   * This is mostly for unit test, so that user can specify ip and port
   * @param host
   * @param port
   * @return
   */
  public static Metrics getMetrics(String host, int port) {
    return new SocketMetrics(host, port);
  }
}
