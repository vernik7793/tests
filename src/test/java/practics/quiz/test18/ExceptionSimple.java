package practics.quiz.test18;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * На месте каждого комментария можно:
 *	- оставить комментарий
 *	- вставить throw new NullPointerException();
 *	- вставить throw new Error();
 * Исправьте тесты. Допишите примеры всех возможных вариантов.
 * Цифрмы должны быть отсортированы в лексикографическом порядке.
 */
public class  ExceptionSimple {

    String s = "";

    private void foo1() {
        s+="0";
        try {
            s+="1";
            if (true) {/*...*/}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {/*...*/}
            s+="4";
        } finally {
            s+="5";
            if (true) {/*...*/}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f1() {
        foo1();
        assertEquals("012567", s);
    }

    private void foo2() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new NullPointerException();}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {/*...*/}
            s+="4";
        } finally {
            s+="5";
            if (true) {/*...*/}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f2() {
        foo2();
        assertEquals("0134567", s);
    }

    private void foo3() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new Error();}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {/*...*/}
            s+="4";
        } finally {
            s+="5";
            if (true) {/*...*/}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f3() {
        try {
            foo3();
        } catch (Error e) {
            assertEquals("0156", s);
        }
    }

    private void foo4() {
        s+="0";
        try {
            s+="1";
            if (true) {/*...*/}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {throw new NullPointerException();}
            s+="4";
        } finally {
            s+="5";
            if (true) {/*...*/}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f4() {
        foo4();
        assertEquals("012567", s);
    }

    private void foo5() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new NullPointerException();}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {throw new NullPointerException();}
            s+="4";
        } finally {
            s+="5";
            if (true) {/*...*/}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f5() {
        try {
            foo5();
        } catch (NullPointerException e) {
            assertEquals("01356", s);
        }
    }

    private void foo6() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new Error();}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {throw new NullPointerException();}
            s+="4";
        } finally {
            s+="5";
            if (true) {/*...*/}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f6() {
        try {
            foo6();
        } catch (Error e) {
            assertEquals("0156", s);
        }
    }

    private void foo7() {
        s+="0";
        try {
            s+="1";
            if (true) {/*...*/}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {throw new Error();}
            s+="4";
        } finally {
            s+="5";
            if (true) {/*...*/}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f7() {
        foo7();
        assertEquals("012567", s);
    }

    private void foo8() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new NullPointerException();}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {throw new Error();}
            s+="4";
        } finally {
            s+="5";
            if (true) {/*...*/}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f8() {
        try {
            foo8();
        } catch (Error e) {
            assertEquals("01356", s);
        }
    }

    private void foo9() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new Error();}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {throw new Error();}
            s+="4";
        } finally {
            s+="5";
            if (true) {/*...*/}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f9() {
        try {
            foo9();
        } catch (Error e) {
            assertEquals("0156", s);
        }
    }

    private void foo10() {
        s+="0";
        try {
            s+="1";
            if (true) {/*...*/}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {/*...*/}
            s+="4";
        } finally {
            s+="5";
            if (true) {throw new NullPointerException();}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f10() {
        try {
            foo10();
        } catch (NullPointerException e) {
            assertEquals("0125", s);
        }
    }

    private void foo11() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new NullPointerException();}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {/*...*/}
            s+="4";
        } finally {
            s+="5";
            if (true) {throw new NullPointerException();}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f11() {
        try {
            foo11();
        } catch (NullPointerException e) {
            assertEquals("01345", s);
        }
    }

    private void foo12() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new Error();}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {/*...*/}
            s+="4";
        } finally {
            s+="5";
            if (true) {throw new NullPointerException();}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f12() {
        try {
            foo12();
        } catch (NullPointerException e) {
            assertEquals("015", s);
        }
    }

    private void foo13() {
        s+="0";
        try {
            s+="1";
            if (true) {/*...*/}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {throw new NullPointerException();}
            s+="4";
        } finally {
            s+="5";
            if (true) {throw new NullPointerException();}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f13() {
        try {
            foo13();
        } catch (NullPointerException e) {
            assertEquals("0125", s);
        }
    }

    private void foo14() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new NullPointerException();}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {throw new NullPointerException();}
            s+="4";
        } finally {
            s+="5";
            if (true) {throw new NullPointerException();}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f14() {
        try {
            foo14();
        } catch (NullPointerException e) {
            assertEquals("0135", s);
        }
    }

    private void foo15() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new Error();}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {throw new NullPointerException();}
            s+="4";
        } finally {
            s+="5";
            if (true) {throw new NullPointerException();}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f15() {
        try {
            foo15();
        } catch (NullPointerException e) {
            assertEquals("015", s);
        }
    }

    private void foo16() {
        s+="0";
        try {
            s+="1";
            if (true) {/*...*/}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {throw new Error();}
            s+="4";
        } finally {
            s+="5";
            if (true) {throw new NullPointerException();}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f16() {
        try {
            foo16();
        } catch (NullPointerException e) {
            assertEquals("0125", s);
        }
    }

    private void foo17() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new NullPointerException();}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {throw new Error();}
            s+="4";
        } finally {
            s+="5";
            if (true) {throw new NullPointerException();}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f17() {
        try {
            foo17();
        } catch (NullPointerException e) {
            assertEquals("0135", s);
        }
    }

    private void foo18() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new Error();}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {throw new Error();}
            s+="4";
        } finally {
            s+="5";
            if (true) {throw new NullPointerException();}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f18() {
        try {
            foo18();
        } catch (NullPointerException e) {
            assertEquals("015", s);
        }
    }

    private void foo19() {
        s+="0";
        try {
            s+="1";
            if (true) {/*...*/}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {/*...*/}
            s+="4";
        } finally {
            s+="5";
            if (true) {throw new Error();}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f19() {
        try {
            foo19();
        } catch (Error e) {
            assertEquals("0125", s);
        }
    }

    private void foo20() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new NullPointerException();}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {/*...*/}
            s+="4";
        } finally {
            s+="5";
            if (true) {throw new Error();}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f20() {
        try {
            foo20();
        } catch (Error e) {
            assertEquals("01345", s);
        }
    }

    private void foo21() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new Error();}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {/*...*/}
            s+="4";
        } finally {
            s+="5";
            if (true) {throw new Error();}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f21() {
        try {
            foo21();
        } catch (Error e) {
            assertEquals("015", s);
        }
    }

    private void foo22() {
        s+="0";
        try {
            s+="1";
            if (true) {/*...*/}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {throw new NullPointerException();}
            s+="4";
        } finally {
            s+="5";
            if (true) {throw new Error();}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f22() {
        try {
            foo22();
        } catch (Error e) {
            assertEquals("0125", s);
        }
    }

    private void foo23() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new NullPointerException();}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {throw new NullPointerException();}
            s+="4";
        } finally {
            s+="5";
            if (true) {throw new Error();}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f23() {
        try {
            foo23();
        } catch (Error e) {
            assertEquals("0135", s);
        }
    }

    private void foo24() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new Error();}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {throw new NullPointerException();}
            s+="4";
        } finally {
            s+="5";
            if (true) {throw new Error();}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f24() {
        try {
            foo24();
        } catch (Error e) {
            assertEquals("015", s);
        }
    }

    private void foo25() {
        s+="0";
        try {
            s+="1";
            if (true) {/*...*/}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {throw new Error();}
            s+="4";
        } finally {
            s+="5";
            if (true) {throw new Error();}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f25() {
        try {
            foo25();
        } catch (Error e) {
            assertEquals("0125", s);
        }
    }

    private void foo26() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new NullPointerException();}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {throw new Error();}
            s+="4";
        } finally {
            s+="5";
            if (true) {throw new Error();}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f26() {
        try {
            foo26();
        } catch (Error e) {
            assertEquals("0135", s);
        }
    }

    private void foo27() {
        s+="0";
        try {
            s+="1";
            if (true) {throw new Error();}
            s+="2";
        } catch (RuntimeException e) {
            s+="3";
            if (true) {throw new Error();}
            s+="4";
        } finally {
            s+="5";
            if (true) {throw new Error();}
            s+="6";
        }
        s+="7";
    }

    @Test
    public void f27() {
        try {
            foo27();
        } catch (Error e) {
            assertEquals("015", s);
        }
    }

}
