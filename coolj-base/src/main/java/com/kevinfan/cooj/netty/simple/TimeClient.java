package com.kevinfan.cooj.netty.simple;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.Date;


/**
 * Created by kevinjom on 14-10-13.
 */
public class TimeClient {
    public static void main(String[] args) {
        ClientBootstrap bootstrap = new ClientBootstrap(new NioClientSocketChannelFactory());
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(new SimpleChannelHandler(){
                    @Override
                    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
                        ChannelBuffer buffer = (ChannelBuffer) e.getMessage();
                        long now = buffer.readInt()*1000L;
                        System.out.println(new Date(now));
                        e.getChannel().close();
                    }
                });
            }
        });

        bootstrap.connect(new InetSocketAddress(8082));
    }
}
