package netty4.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class TimeDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        if (in.readableBytes() < 4) {
            return;
        }

        out.add(new UnixTime(in.readInt()));
    }
}

//public class TimeDecoder extends ReplayingDecoder<Void> {
//    @Override
//    protected void decode(
//            ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
//        out.add(in.readBytes(4));
//    }
//}