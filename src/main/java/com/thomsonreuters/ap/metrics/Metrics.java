package com.thomsonreuters.ap.metrics;

import java.io.IOException;

public interface Metrics {
  /**
   * 
   * @param metricPath eg: tr.analytics-predictive.arm
   * @param metricsValue eg: 18
   * @param seconds eg: 1498210178
   * @throws IOException 
   */
  void add(String metricPath, String metricsValue, long seconds) throws IOException;
}
