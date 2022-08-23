package ru.job4j.asserj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        assertThat(box.whatsThis()).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        assertThat(box.whatsThis()).isEqualTo("Tetrahedron");
    }

    @Test
    void isThisUnknowObject() {
        Box box = new Box(2, 10);
        assertThat(box.getNumberOfVertices()).isEqualTo(-1);
    }

    @Test
    void sphereVertices() {
        Box box = new Box(0, 10);
        assertThat(box.getNumberOfVertices()).isEqualTo(0);
    }

    @Test
    void sphereArea() {
        Box box = new Box(0, 7);
        assertThat(box.getArea()).isEqualTo(615.7521601035994);
    }

    @Test
    void tetrahedronArea() {
        Box box = new Box(4, 10);
        assertThat(box.getArea()).isEqualTo(173.20508075688772);
    }

    @Test
    void isExist() {
        Box box = new Box(8, 10);
        assertThat(box.isExist()).isTrue();
    }

    @Test
    void isNotExist() {
        Box box = new Box(5, 0);
        assertThat(box.isExist()).isFalse();
    }
}