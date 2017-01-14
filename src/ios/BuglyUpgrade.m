//
//  BuglyUpgrade.m
//  爱尔生活
//
//  Created by cdm on 14/01/2017.
//
//

#import "BuglyUpgrade.h"
#import <BuglyHotfix/Bugly.h>

@implementation BuglyUpgrade

- (void)initApp:(CDVInvokedUrlCommand *)command {
    NSArray *arguments = command.arguments;
    NSString *androidAppkey = [arguments objectAtIndex:0];
    NSString *iosAppkey = [arguments objectAtIndex:1];
    
    [Bugly startWithAppId:iosAppkey
#ifdef DEBUG
        developmentDevice:YES
#endif
                   config:nil];
    
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
