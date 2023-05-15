package com.guguhowie.other;

import java.util.Date;

/**
 * 未决行为，输出是不确定的
 */
public class UncertainDemo {

    public long caculateDelayDays(Date dueTime) {
        // 当前时间不可控，有可能今天是输出0，明天就是输出days
        // 可以将currentTimeMillis抽为参数
        long currentTimeMillis = System.currentTimeMillis();
        if (dueTime.getTime() > currentTimeMillis) {
            return 0;
        }

        long time = currentTimeMillis - dueTime.getTime();
        long days = time / 86400;
        return days;
    }
}
/**
 * 静态方法不会暴露内部生成的细节，我们不清楚依赖关系，很难去mock
 * 全局性 绑定的是类 而不是对象 可能会cao
 * 只有在这个静态方法执行耗时太长、依赖外部资源、逻辑复杂、行为未决等情
 * 况下，我们才需要在单元测试中 mock 这个静态方法。
 *
 *
 * 全局变量，可能会在不同单测中执行影响到，出现未预测结果
 *
 * 复杂继承越底层的子类要
 * mock 的对象可能就会越多，这样就会导致，底层子类在写单元测试的时候，要一个一个
 * mock 很多依赖对象，而且还需要查看父类代码，去了解该如何 mock 这些依赖对象。
 *
 *
 *
 *
 * 高耦合代码
 * 如果一个类职责很重，需要依赖十几个外部对象才能完成工作，代码高度耦合，那我们在编
 * 写单元测试的时候，可能需要 mock 这十几个依赖的对象。不管是从代码设计的角度来
 * 说，还是从编写单元测试的角度来说，这都是不合理的。
 *
 * 依赖注入是编写可测试性代码的最有效手段。通过依赖注入，我们在编写单元测试的时候，
 * 可以通过 mock 的方法解依赖外部服务，也就是我这个类的能力来源有根可寻
 */
