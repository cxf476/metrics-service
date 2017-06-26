package com.thomsonreuters.ap.metrics;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MetricsServiceIntegTest {

  private static final int WRONG_PORT = 19999;
  private static final String WRONG_HOST = "192.168.0.1";
  @Test
  public void testMetricsService_withDefaultMetrics_canAddMetrics() throws IOException {
    Metrics metrics = MetricsService.getMetrics();
    
    for(int i = 0; i<10;++i) {
      Assert.assertTrue(metrics.add("test.java.testng", String.valueOf(1000+i), System.currentTimeMillis()/1000 - 3600*i));
    }
  }
  
  @Test
  public void testMetricsService_whenConnectingToWrongServer_shouldFailFast() throws IOException {
    Metrics metrics = MetricsService.getMetrics(WRONG_HOST, SocketMetrics.DEFAULT_PORT);
    Assert.assertFalse(metrics.add("test.java.testng", "1", 0));
  }
  
  @Test
  public void testMetricsService_whenConnectingToWrongPort_shouldFailFast() throws IOException {
    Metrics metrics = MetricsService.getMetrics(SocketMetrics.DEFAULT_HOST, WRONG_PORT);
    Assert.assertFalse(metrics.add("test.java.testng", "1", 0));
  }

}
