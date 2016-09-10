package br.com.jera.todo.models;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by marco on 9/10/16.
 */

public class TaskState {

    @Retention(SOURCE)
    @IntDef({TODO, DONE})
    public @interface State {}

    public static final int TODO = 1;
    public static final int DONE = 2;


}
