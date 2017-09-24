package practics.quiz.test19;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * На месте каждого комментария можно:
 * - оставить комментарий
 * - вставить throw new NullPointerException();
 * - вставить throw new RuntimeException();
 * - вставить throw new IOException();
 * - вставить throw new Error();
 * Исправьте тесты. Допишите примеры всех возможных вариантов.
 * Варианты должны быть отсортированы в лексикографическом порядке.
*/
public class ExceptionMultiCatch {

    String s = "";

    private void foo1() {
        s+="0";
        try {
            s+="1";
            if (true) {/**/}
            s+="2";
        } catch (NullPointerException e) {
            s+="3";
            if (true) {/**/}
            s+="4";
        } catch (RuntimeException e) {
            s+="5";
            if (true) {/**/}
            s+="6";
        } catch (Exception e) {
            s+="7";
            if (true) {/**/}
            s+="8";
        } finally {
            s+="9";
            if (true) {/**/}
            s+="10";
        }
        s+="11";
    }

    @Test
    public void f1() {
        foo1();
        assertEquals("01291011", s);
    }

    private void foo2() {
        s+="0";
        try {
            s+="1";
            if (true) {/*...*/}
            s+="2";
        } catch (NullPointerException e) {
            s+="3";
            if (true) {/**/}
            s+="4";
        } catch (RuntimeException e) {
            s+="5";
            if (true) {/**/}
            s+="6";
        } catch (Exception e) {
            s+="7";
            if (true) {/**/}
            s+="8";
        } finally {
            s+="9";
            if (true) {/**/}
            s+="10";
        }
        s+="11";
    }

    @Test
    public void f2() {
        foo2();
        assertEquals("01291011", s);
    }

    private void foo3() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new Error();}
            s+="2";
        } catch (NullPointerException e) {
            s+="3";
            if (true) {/*...*/}
            s+="4";
        } catch (RuntimeException e) {
            s+="5";
            if (true) {/**/}
            s+="6";
        } catch (Exception e) {
            s+="7";
            if (true) {/**/}
            s+="8";
        } finally {
            s+="9";
            if (true) {throw new NullPointerException();}
            s+="10";
        }
        s+="11";
    }

    @Test
    public void f3() {
        try {
            foo3();
            fail();
        } catch (NullPointerException e) {
            assertEquals("019", s);
        }
    }

    private void foo4() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new IOException();}
            s+="2";
        } catch (NullPointerException e) {
            s+="3";
            if (true) {/*...*/}
            s+="4";
        } catch (RuntimeException e) {
            s+="5";
            if (true) {/**/}
            s+="6";
        } catch (Exception e) {
            s+="7";
            if (true) {throw new NullPointerException();}
            s+="8";
        } finally {
            s+="9";
            if (true) {/*...*/}
            s+="10";
        }
        s+="11";
    }

    @Test
    public void f4() {
        try {
            foo4();
            fail();
        } catch (NullPointerException e) {
            assertEquals("017910", s);
        }
    }

    private void foo5() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new RuntimeException();}
            s+="2";
        } catch (NullPointerException e) {
            s+="3";
            if (true) {/**/}
            s+="4";
        } catch (RuntimeException e) {
            s+="5";
            if (true) {/**/}
            s+="6";
        } catch (Exception e) {
            s+="7";
            if (true) {/**/}
            s+="8";
        } finally {
            s+="9";
            if (true) {/**/}
            s+="10";
        }
        s+="11";
    }

    @Test
    public void f5() {
        foo5();
        assertEquals("015691011", s);
    }

    private void foo6() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new RuntimeException();}
            s+="2";
        } catch (NullPointerException e) {
            s+="3";
            if (true) {/*...*/}
            s+="4";
        } catch (RuntimeException e) {
            s+="5";
            if (true) {throw new NullPointerException();}
            s+="6";
        } catch (Exception e) {
            s+="7";
            if (true) {/**/}
            s+="8";
        } finally {
            s+="9";
            if (true) {/*...*/}
            s+="10";
        }
        s+="11";
    }

    @Test
    public void f6() {
        try {
            foo6();
            fail();
        } catch (NullPointerException e) {
            assertEquals("015910", s);
        }
    }

    private void foo7() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new NullPointerException();}
            s+="2";
        } catch (NullPointerException e) {
            s+="3";
            if (true) {throw new NullPointerException();}
            s+="4";
        } catch (RuntimeException e) {
            s+="5";
            if (true) {/*...*/}
            s+="6";
        } catch (Exception e) {
            s+="7";
            if (true) {/**/}
            s+="8";
        } finally {
            s+="9";
            if (true) {throw new NullPointerException();}
            s+="10";
        }
        s+="11";
    }

    @Test
    public void f7() {
        try {
            foo7();
            fail();
        } catch (NullPointerException e) {
            assertEquals("0139", s);
        }
    }

    private void foo8() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new IOException();}
            s+="2";
        } catch (NullPointerException e) {
            s+="3";
            if (true) {/**/}
            s+="4";
        } catch (RuntimeException e) {
            s+="5";
            if (true) {/*...*/}
            s+="6";
        } catch (Exception e) {
            s+="7";
            if (true) {throw new Error();}
            s+="8";
        } finally {
            s+="9";
            if (true) {throw new NullPointerException();}
            s+="10";
        }
        s+="11";
    }

    @Test
    public void f8() {
        try {
            foo8();
            fail();
        } catch (NullPointerException e) {
            assertEquals("0179", s);
        }
    }

    private void foo9() throws Exception {
        s+="0";
        try {
            s+="1";
            if (true) {throw new IOException();}
            s+="2";
        } catch (NullPointerException e) {
            s+="3";
            if (true) {/**/}
            s+="4";
        } catch (RuntimeException e) {
            s+="5";
            if (true) {/*...*/}
            s+="6";
        } catch (Exception e) {
            s+="7";
            if (true) {throw new IOException();}
            s+="8";
        } finally {
            s+="9";
            if (true) {/*...*/}
            s+="10";
        }
        s+="11";
    }

    @Test
    public void f9() {
        try {
            foo9();
            fail();
        } catch (Exception e) {
            assertEquals("017910", s);
        }
    }

    private void foo10() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new NullPointerException();}
            s+="2";
        } catch (NullPointerException e) {
            s+="3";
            if (true) {throw new RuntimeException();}
            s+="4";
        } catch (RuntimeException e) {
            s+="5";
            if (true) {throw new RuntimeException();}
            s+="6";
        } catch (Exception e) {
            s+="7";
            if (true) {/**/}
            s+="8";
        } finally {
            s+="9";
            if (true) {/**/}
            s+="10";
        }
        s+="11";
    }

    @Test
    public void f10() {
        try {
            foo10();
            fail();
        } catch (Exception e) {
            assertEquals("013910", s);
        }
    }

}

