package com.thomsonreuters.ap.metrics;

public interface Metrics {

  /**
   * @param metricPath eg: tr.analytics-predictive.arm
   * @param metricsValue eg: 18
   * @param seconds eg: 1498210178
   * @return false if got any exception
   */
  boolean add(String metricPath, String metricsValue, long seconds) ;
  
  /**
   * @param metricPath eg: tr.analytics-predictive.arm
   * @param metricsValue eg: 18
   * @return false if got any exception
   */
  boolean add(String metricPath, String metricsValue) ;
}
