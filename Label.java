import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Serializable;

//label
enum Label {
    NORMAL,
    VIP;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}