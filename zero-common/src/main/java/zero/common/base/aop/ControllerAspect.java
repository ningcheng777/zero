package zero.common.base.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import zero.common.base.exception.CommonServiceException;
import zero.common.base.result.Result;
import zero.common.base.result.ResultStatus;

/**
 * @author ningcheng
 * @date 2017/11/20
 */
@Component
@Aspect
public class ControllerAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(org.springframework.web.bind.annotation.ResponseBody)")
    public Result afterThrowing(ProceedingJoinPoint joinPoint) throws Exception {
        try {
            return (Result) joinPoint.proceed();
        } catch (Throwable e) {
            Result ret = new Result();
            ret.setSuccess(false);
            String location = joinPoint.getTarget().getClass().getName() + "#" + joinPoint.getSignature().getName() + " ";
            if (e instanceof CommonServiceException) {
                logger.warn(location + e.getMessage(), e);
                ret.setMsg(e.getMessage());
                ret.setStatus(ResultStatus.BUSINESS_ERROR);
            } else {
                logger.error(location + e.getMessage(), e);
                ret.setMsg("系统错误");
                ret.setStatus(ResultStatus.SYSTEM_ERROR);
            }
            return ret;
        }
    }
}
