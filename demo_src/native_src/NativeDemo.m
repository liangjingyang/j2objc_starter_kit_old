#import "NativeDemo.h"

@implementation NativeDemo

- (id)init
{
    self = [super init];
    if (self) {
    }
    
    return self;
}

- (void)getText:(int) count{
    return ;
}

- (int)getInt:(int (^)(void)) block{
    return block();
}

@end
