package vn.menugo.server.monitor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SystemArchitecture {
    /**
     * A join point is in the web layer if the method is defined
     * in a type in the vn.menugo.server package or any sub-package
     * under that.
     */
    @Pointcut("within(vn.menugo.server..*)")
    public void inWebLayer() {
    }

    /**
     * A join point is in the service layer if the method is defined
     * in a type in the vn.menugo.server.services package or any sub-package
     * under that.
     */
    @Pointcut("within(vn.menugo.server.service..*)")
    public void inServiceLayer() {
    }

    /**
     * A join point is in the data access layer if the method is defined
     * in a type in the vn.menugo.server.controllers or any sub-package
     * under that.
     */
    @Pointcut("within(vn.menugo.server.controller..*)")
    public void inControllerLayer() {
    }

    /**
     * A join point is in the data access layer if the method is defined
     * in a type in the vn.menugo.server.controllers or any sub-package
     * under that.
     */
    @Pointcut("within(vn.menugo.server.repo..*)")
    public void inDataAccessLayer() {
    }

    /**
     * A business service is the execution of any method defined on a service
     * interface. This definition assumes that interfaces are placed in the
     * "service" package, and that implementation types are in sub-packages.
     * <p>
     * If you group service interfaces by functional area (for example,
     * in packages com.xyz.someapp.abc.service and com.xyz.someapp.def.service) then
     * the pointcut expression "execution(* com.xyz.someapp..service.*.*(..))"
     * could be used instead.
     * <p>
     * Alternatively, you can write the expression using the 'bean'
     * PCD, like so "bean(*Service)". (This assumes that you have
     * named your Spring service beans in a consistent fashion.)
     */
    @Pointcut("execution(* vn.menugo.server.service.*.*(..))")
    public void businessService() {
    }

    /**
     * A data access operation is the execution of any method defined on a
     * repo interface. This definition assumes that interfaces are placed in the
     * "repo" package, and that implementation types are in sub-packages.
     */
    @Pointcut("execution(* vn.menugo.server.repo.*.*(..))")
    public void dataAccessOperation() {
    }

    /**
     *
     */
    @Pointcut("execution(* vn.menugo.server.controller.*.*(..))")
    public void controllerOperation() {
    }

    /**
     *
     */
    @Pointcut("args(uid)")
    public void intArgsRequest(int uid) {
    }

    /**
     *
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void getMethodOperation() {
    }

    /**
     *
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postMethodOperation() {
    }

    /**
     *
     */
    @Pointcut(value = "execution(* vn.menugo.server..*Controller.*OnSecure(..))")
    public void secureMethod() {
    }

//    /**
//     *
//     */
//    @Pointcut("execution(* vn.menugo.server..*Controller.*OnSecure(..))")
//    public void secureMethod() {}

}
