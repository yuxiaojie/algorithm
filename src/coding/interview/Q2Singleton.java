package coding.interview;

public class Q2Singleton {

    /**
     * 单件模式
     *
     * 懒加载，适合单线程模式，如果是多线程下同时访问 getInstance() 方法，可能会导致对象实例重复创建
     */
    public static class Singleton1 {

        private static Singleton1 instance = null;

        /**
         * 私有的构造器防止外部创建对象
         */
        private Singleton1() {}

        public static Singleton1 getInstance() {
            if (instance == null) {
                instance = new Singleton1();
            }
            return instance;
        }
    }

    /**
     * 单件模式
     *
     * 静态加载，适用于多线程及单线程环境，一开始就会加载资源，如果资源较大或申请时间较多，可能会有性能问题
     */
    public static class Singleton2 {

        private static Singleton2 instance = new Singleton2();

        /**
         * 私有的构造器防止外部创建对象
         */
        private Singleton2() {}

        public static Singleton2 getInstance() {
            return instance;
        }
    }

    /**
     * 单件模式
     *
     * 懒加载，适用于多线程及单线程环境，但是性能较差，除了一开始创建的时候可能会有竞争的问题，一旦创建完成后是不存在竞争的，
     * 但是所有的获取操作均需要加锁，会导致获取资源速度性能比较差
     *
     */
    public static class Singleton3 {

        private static final Object lock = new Object();
        private static Singleton3 instance = null;

        /**
         * 私有的构造器防止外部创建对象
         */
        private Singleton3() {}

        public static Singleton3 getInstance() {

            synchronized (lock) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
            return instance;
        }
    }


    /**
     * 单件模式
     *
     * 懒加载，适用于多线程及单线程环境，仅仅在一开始没有实例引用的情况下加锁，后续是不需要加锁的，所以方案最优
     */
    public static class Singleton4 {

        private static final Object lock = new Object();
        private static Singleton4 instance = null;

        /**
         * 私有的构造器防止外部创建对象
         */
        private Singleton4() {}

        public static Singleton4 getInstance() {

            if (instance == null) {
                synchronized (lock) {
                    if (instance == null) {
                        instance = new Singleton4();
                    }
                }
            }
            return instance;
        }

    }
}
