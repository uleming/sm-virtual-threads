# sm-virtual-threads


Use the JMetter or apache ab to make stress test. 
On MacOS(M1) ab doesn't work properly (disconnects) occasionally. 
Apache Benchmark utility is replaced with JMetter. The Jmetter configuration file 
"HTTP Request.jmx" is in root directory. 

Virtual threads is preview feature of jdk 20. Get temurin jdk https://adoptium.net/

Set value of the property "virtual-threads.enabled" to "true" to enable
virtual threads and rerun JMetter stress test

