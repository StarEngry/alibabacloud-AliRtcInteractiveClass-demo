//
//  NetworkManager.m
//  LectureHall
//
//  Created by alibaba on 2020/5/22.
//  Copyright © 2020 alibaba. All rights reserved.
//

#import "NetworkManager.h"
#import <AFNetworking/AFNetworking.h>
#import "AppConfig.h"

@implementation NetworkManager

+ (AFHTTPSessionManager*) manager
{
    static dispatch_once_t onceToken;
    static AFHTTPSessionManager *manager = nil;
    dispatch_once(&onceToken, ^{
        manager = [AFHTTPSessionManager manager];
        manager.responseSerializer.acceptableContentTypes = [NSSet setWithObjects:@"application/json",@"text/json", @"text/javascript",@"text/html",@"text/plain",nil];
        manager.requestSerializer=[AFHTTPRequestSerializer serializer];
        manager.requestSerializer.timeoutInterval = 10;
        manager.securityPolicy = [AFSecurityPolicy defaultPolicy];
        manager.securityPolicy.allowInvalidCertificates = YES;
        manager.securityPolicy.validatesDomainName = NO;
    });
    
    return manager;
}


+ (void)GET:(NSString *)route
              parameters:(id _Nullable)parameters
       completionHandler:(void (^)(NSString *__nullable errString,NSDictionary *_Nullable resultDic))handle{
    [self.manager GET:[kBaseUrl stringByAppendingString:route] parameters:parameters success:^(NSURLSessionDataTask *task, id responseObject){
            if ([responseObject isKindOfClass:[NSDictionary class]]) {
                NSDictionary *resultDic = (NSDictionary *)responseObject;
                NSNumber *code = resultDic[@"code"];
                if(code.intValue == 200)
                    handle(nil,resultDic[@"data"]);
                }else{
                    handle(@"数据格式异常",nil);
                }
        } failure:^(NSURLSessionDataTask *task, NSError *error) {
             handle(error.description,nil);
        }];
}

@end
