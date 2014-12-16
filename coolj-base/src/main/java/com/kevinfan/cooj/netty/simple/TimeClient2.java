package com.kevinfan.cooj.netty.simple;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

import java.net.InetSocketAddress;

/**
 * Created by kevinjom on 14-10-13.
 */
public class TimeClient2 {
    public static void main(String[] args) {
        ChannelFactory channelFactory = new NioClientSocketChannelFactory();
        ClientBootstrap bootstrap = new ClientBootstrap(channelFactory);
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(new TimeDecoder(), new TimeHandler());
            }
        });
        ChannelFuture future = bootstrap.connect(new InetSocketAddress(8083));
        future.awaitUninterruptibly();
        if (!future.isSuccess()) {
            future.getCause().printStackTrace();
        }

        future.getChannel().getCloseFuture().awaitUninterruptibly();
        channelFactory.releaseExternalResources();

    }

    public static class TimeDecoder extends FrameDecoder {

        @Override
        protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer) throws Exception {
            if (buffer.readableBytes() < 4) {
                return null;
            }
            return new UnixTime(buffer.readInt());
        }
    }

    public static class TimeHandler extends SimpleChannelHandler {
        @Override
        public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
            UnixTime unixTime = (UnixTime) e.getMessage();
            System.out.println(unixTime);
            e.getChannel().close();
        }
    }
}
