package com.sdyb.mp.exception;

import lombok.Data;

@Data
public class MpException extends RuntimeException {

  private int code;
  private String msg;

    public MpException(){

    }

  public MpException(int code){
      this.code=code;
  }

  public MpException(String msg) {
    this.msg = msg;
  }

    public MpException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
