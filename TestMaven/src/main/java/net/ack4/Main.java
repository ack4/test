package net.ack4;

import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.logging.log4j.Logger;

public class Main {
	public final static Logger SLOG = Util.getLogger("net.ack4.log.info1");
	public final static Logger LOG = Util.getLogger("net.ack4.log.info2");
	public final static String IP_ADDR = "192.168.1.7";
	public final static int PORT = 9000;

	public static void main(String[] args) throws IOException {
		Long start = System.currentTimeMillis();

		Udp udp = new Udp();
		for (int i = 0; i < 100; i++) {
			udp.send(IP_ADDR, PORT, Util.tee(LocalDateTime.now().toLocalTime() + "\n"));
		}
		udp.send(IP_ADDR, PORT, Util.tee("\\d"));
		udp.close();
		
		
		Long end = System.currentTimeMillis();
		SLOG.info(end - start + "[ms]");
	}
}