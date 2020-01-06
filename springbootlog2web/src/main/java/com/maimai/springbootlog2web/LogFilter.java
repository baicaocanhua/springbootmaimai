package com.maimai.springbootlog2web;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

import java.text.DateFormat;
import java.util.Date;

public class LogFilter extends Filter {
    // @Override
    // public FilterReply decide(ILoggingEvent event) {
    //     LoggerMessage loggerMessage = new LoggerMessage(
    //             event.getMessage()
    //             , DateFormat.getDateTimeInstance().format(new Date(event.getTimeStamp())),
    //             event.getThreadName(),
    //             event.getLoggerName(),
    //             event.getLevel().levelStr
    //     );
    //     LoggerQueue.getInstance().push(loggerMessage);
    //     return FilterReply.ACCEPT;
    // }

    /**
     * If the decision is <code>{@link FilterReply#DENY}</code>, then the event will be
     * dropped. If the decision is <code>{@link FilterReply#NEUTRAL}</code>, then the next
     * filter, if any, will be invoked. If the decision is
     * <code>{@link FilterReply#ACCEPT}</code> then the event will be logged without
     * consulting with other filters in the chain.
     *
     * @param event The event to decide upon.
     */
    @Override
    public FilterReply decide(Object event1) {
        ILoggingEvent event = (ILoggingEvent) event1;
        LoggerMessage loggerMessage = new LoggerMessage(
                event.getMessage()
                , DateFormat.getDateTimeInstance().format(new Date(event.getTimeStamp())),
                event.getThreadName(),
                event.getLoggerName(),
                event.getLevel().levelStr
        );
        LoggerQueue.getInstance().push(loggerMessage);
        return FilterReply.ACCEPT;
    }
}
