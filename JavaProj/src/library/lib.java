package library;

import java.util.List;

public interface lib <T> {
boolean delete (T o);
T findByMat(int mat);
List <T> findAll();
}
