package br.com.jera.todo.models;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;

/**
 * Created by marco on 9/10/16.
 */

public class TaskTest {


    Task task;

    @Before
    public void createTask() {
        task = new Task("Fazer compras");
    }


    @Test
    public void taksCreation( ) {
        assertEquals(task.getName(), "Fazer compras");
        assertEquals(task.getStatus(), TaskState.TODO);
    }

    @Test
    public void checkingTaskState(){
        assertFalse(task.isDone());
        task.setStatus(TaskState.DONE);
        assertTrue(task.isDone());
    }

    @Test
    public void settingUpCreatedAtAndUpdatedAt() {
        task.beforeSave();
        assertNotNull(task.getCreatedAt());
        assertNotNull(task.getUpdatedAt());
        assertEquals(task.getUpdatedAt(), task.getCreatedAt());
    }

    @Test
    public void updatingUpdatedAtValue() throws InterruptedException {
        task.beforeSave();
        assertSame(task.getUpdatedAt(), task.getCreatedAt());
        Thread.sleep(300);
        task.beforeSave();
        assertNotSame(task.getUpdatedAt(), task.getCreatedAt());
        assertTrue(task.getUpdatedAt().after(task.getCreatedAt()));
    }

    @Test
    public void modelWithoutNameIsInvalid() {
        task.setName(null);
        assertFalse(task.isValid());
        task.setName("");
        assertFalse(task.isValid());
    }

}
