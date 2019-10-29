package com.viewscenes.common.filter;

import com.viewscenes.common.constant.Constant;
import org.apache.dubbo.common.Constants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.slf4j.MDC;

@Activate(group = {Constants.PROVIDER, Constants.CONSUMER}, order = 99)
public class TraceIdFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        String tid = MDC.get(Constant.TRACEID);
        String rpcTid = RpcContext.getContext().getAttachment(Constant.TRACEID);

        boolean bind = false;
        if (tid != null) {
            RpcContext.getContext().setAttachment(Constant.TRACEID, tid);
        } else {
            if (rpcTid != null) {
                MDC.put(Constant.TRACEID,rpcTid);
                bind = true;
            }
        }
        try{
            return invoker.invoke(invocation);
        }finally {
            if (bind){
                MDC.remove(Constant.TRACEID);
            }
        }
    }
}
