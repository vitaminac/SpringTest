package com.core.web.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
//    @Bean
//    public WebMvcRegistrations webMvcRegistrationsHandlerMapping() {
//        return new WebMvcRegistrations() {
//            @Override
//            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
//                return new RequestMappingHandlerMapping() {
//                    @Override
//                    protected void registerHandlerMethod(Object handler, Method method, RequestMappingInfo mapping) {
//                        Class<?> beanType = method.getDeclaringClass();
//                        if (AnnotationUtils.findAnnotation(beanType, RestController.class) != null) {
//                            PatternsRequestCondition apiPattern = new PatternsRequestCondition(API_ENDPOINT)
//                                    .combine(mapping.getPatternsCondition());
//
//                            mapping = new RequestMappingInfo(mapping.getName(), apiPattern,
//                                    mapping.getMethodsCondition(), mapping.getParamsCondition(),
//                                    mapping.getHeadersCondition(), mapping.getConsumesCondition(),
//                                    mapping.getProducesCondition(), mapping.getCustomCondition());
//                        }
//                        super.registerHandlerMethod(handler, method, mapping);
//                    }
//                };
//            }
//        };
//    }
}