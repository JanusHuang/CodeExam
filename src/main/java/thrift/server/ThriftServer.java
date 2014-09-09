package thrift.server;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportFactory;
import thrift.idl.IndexNewsOperatorServices;
import thrift.impl.IndexNewsOperatorServicesImpl;

import java.net.InetSocketAddress;

/**
 * @author zhijing.huang
 *         Created by zhijing.huang on 2014/9/9.
 */
public class ThriftServer {
    public static void main(String[] args) {
        IndexNewsOperatorServices.Processor processor = new IndexNewsOperatorServices.Processor(new IndexNewsOperatorServicesImpl());
        try {
            TServerTransport serverTransport = new TServerSocket(new InetSocketAddress("0.0.0.0", 9813));
            TThreadPoolServer.Args trArgs = new TThreadPoolServer.Args(serverTransport);
            trArgs.processor(processor);
            trArgs.transportFactory(new TTransportFactory());

            TServer server = new TThreadPoolServer(trArgs);
            System.out.println("server begin ......................");
            server.serve();
            System.out.println("-----------------------------------");
            server.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
