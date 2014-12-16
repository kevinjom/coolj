package com.kevinfan.cooj.netty.simple;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;


/**
 * Created by kevinjom on 14-10-13.
 */
public class TimeServer2 {
    public static void main(String[] args) {
        ServerBootstrap bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory());
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(new RequestHandler(), new TimeEncoder());
            }
        });
        bootstrap.bind(new InetSocketAddress(8083));
        System.out.println("Time Server stared...");
    }

    public static class TimeEncoder extends SimpleChannelHandler {
        @Override
        public void writeRequested(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
            UnixTime time = (UnixTime) e.getMessage();
            if (time != null) {
                ChannelBuffer buffer = ChannelBuffers.buffer(4);
                buffer.writeInt(time.getTimestamp());

                Channels.write(ctx, e.getFuture(), buffer);
            }
        }
    }

    public static class RequestHandler extends SimpleChannelHandler {
        @Override
        public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
            UnixTime now = new UnixTime((int) (System.currentTimeMillis() / 1000));
            ChannelFuture future = e.getChannel().write(now);
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }
}
