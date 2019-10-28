package com.thread;

public class ThreadStudy {
  public static void main() {}

  private void makeThreads() throws InterruptedException {
    /*
     * <p> 1. A thread is a lightweight sub-process, the smallest unit of processing.
     *  It is a separate path of execution.
     * 2. A thread is a thread of execution in a program
     *  However, we use multithreading than multiprocessing because threads use
     *  a shared memory area. They don't allocate separate memory area so saves memory,
     *  and context-switching between the threads takes less time than process.
     *
     * </p>
     */
    Thread th = new Thread();
    /*
    New , Runable, time_wait (sleep, wait , join ) ,
    Thread.State.NEW ; Thread.State.RUNNABLE; Thread.State.BLOCKED; Thread.State.WAITING;
    Thread.State.TIMED_WAITING; Thread.State.TERMINATED;
    New
    Runnable
    Non-Runnable (Blocked)
    Terminated*/
    Thread.State state = th.getState();

    /*
     * Impliment Thread class' run method
     */
    new Thread() {

      @Override
      public void run() {
        System.out.println("Runnig");
      }
    }.start();

    /*
     * Methods of Thread class which are imp
     */

    /*
     *  it calls start0 method which is a NATIVE
     *  Throws IllegalThreadStateException
     *
     *  if override then no job will be done, but if required the
     *  call super.start();
     */
    new Thread().start();
    new Thread().run();
    new Thread().join();
    /*Interrupts this thread.
    1.    Unless the current thread is interrupting itself, which is always permitted, the checkAccess method
          of this thread is invoked, which may cause a SecurityException to be thrown.
          If this thread is blocked in an invocation of the wait(), wait(long), or wait(long, int) methods of the
          Object class, or of the join(), join(long), join(long, int), sleep(long), or sleep(long, int), methods
          of this class, then its interrupt status will be cleared and it will receive an InterruptedException.
          If this thread is blocked in an I/O operation upon an InterruptibleChannel then the channel will be
         closed, the thread's interrupt status will be set, and the thread will receive a ClosedByInterruptException.
         If this thread is blocked in a Selector then the thread's interrupt status will be set and it will return
         immediately from the selection operation, possibly with a non-zero value, just as if the selector's wakeup method
          were invoked.
         If none of the previous conditions hold then this thread's interrupt status will be set.
         Interrupting a thread that is not alive need not have any effect.

       2.  In the program, there is no exception occurred during the execution of thread. H
           ere, interrupt only sets the interrupted flag to true, which can be used by java programmer later.
       */

    new Thread().interrupt();
  }
}
