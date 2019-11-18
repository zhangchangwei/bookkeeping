package com.book.keeping.bookkeeping.common.result;

import com.book.keeping.bookkeeping.config.transfer.PageListTrasfer;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * 返回值实体类
 *
 * @author zhang.penghao
 * @version V1.0
 * @date 2019/11/18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public Result(ResultEnum type){
        this.code = type.getCode();
        this.msg = type.getMessage();
    }

    public Result(ResultEnum type,String content){
        this.code = type.getCode();
        this.msg = content;
    }

    public Result(ResultEnum type,T data){
        this.code = type.getCode();
        this.msg = type.getMessage();
        this.data = data;
    }

    public Result(ResultEnum type,String content ,T data){
        this.code = type.getCode();
        this.msg = content;
        this.data = data;
    }

    public static Result success(){
        return new Result(ResultEnum.SUCCESS);
    }

    public static <T> Result<T> success(T data){
        if(data instanceof PageInfo){
            PageListTrasfer pageListTrasfer = new PageListTrasfer();
            BeanUtils.copyProperties(data, pageListTrasfer);
            return new Result(ResultEnum.SUCCESS, pageListTrasfer);
        }
        return new Result(ResultEnum.SUCCESS, data);
    }

    public static Result error(ResultEnum type){
        return new Result(type);
    }

    public static Result error(ResultEnum type,String content){
        return new Result(type,content);
    }
}
