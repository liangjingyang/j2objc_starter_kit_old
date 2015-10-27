#import <Foundation/Foundation.h>

@interface NativeDemo : NSObject

- (void)getText:(int) count;

- (int)getInt:(int (^)(void)) block;

@end
