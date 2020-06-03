package generate;

import generate.Book;

public interface BookDao {
    int deleteByPrimaryKey(String bid);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(String bid);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}