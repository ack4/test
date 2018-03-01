package net.ack4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Udp {
	private final static int CLIENT_PORT = 9999;
	private final static int ALLOCATE_SIZE = 48;
	//private final static int ALLOCATE_SIZE = 2048;
	private DatagramChannel channel;
	private ByteBuffer buf = ByteBuffer.allocate(ALLOCATE_SIZE);

	public Udp() throws IOException {
		channel = DatagramChannel.open();
		// 送信元ポート(nullの場合はランダム)
		channel.socket().bind(new InetSocketAddress(CLIENT_PORT));
	}

	public void send(String addr, int port, Object message) throws IOException {
		buf.clear();
		buf.put(message.toString().getBytes());
		buf.flip();
		channel.send(buf, new InetSocketAddress(addr, port));
	}

	public void close() throws IOException {
		channel.close();
	}
}
