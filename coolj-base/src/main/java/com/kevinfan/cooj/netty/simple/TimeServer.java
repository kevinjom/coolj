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
public class TimeServer {
    public static void main(String[] args) {
        final ServerBootstrap bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory());
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(new SimpleChannelHandler() {
                    @Override
                    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
                        ChannelBuffer now = ChannelBuffers.buffer(4);
                        now.writeInt((int) (System.currentTimeMillis() / 1000L));

                        ChannelFuture future = e.getChannel().write(now);

                        future.addListener(new ChannelFutureListener() {
                            @Override
                            public void operationComplete(ChannelFuture future) throws Exception {
                                future.getChannel().close();
                            }
                        });

                    }

                    @Override
                    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
                        e.getCause().printStackTrace();
                        e.getChannel().close();

                    }
                });
            }
        });

        bootstrap.bind(new InetSocketAddress(8082));
        System.out.println("Time Server started...");
    }
}
