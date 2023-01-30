package com.ssafy.townbook.controller;

import com.google.zxing.WriterException;
import com.ssafy.townbook.model.service.MyPageServiceImpl;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

/**
 * 로그인 유저의 마이페이지 컨트롤러
 */
@RestController
@RequestMapping("/myPage")
public class MyPageController {

    @Autowired
    private MyPageServiceImpl myPageService;

    /**
     * 로그인 유저의 이메일로 만든 QR코드 반환
     *
     * @param accountEmail
     * @return Optional<Object>
     * @throws WriterException
     * @throws IOException
     */
    @GetMapping("/qr/{accountEmail}")
    public ResponseEntity<?> createQr(@PathVariable String accountEmail) throws WriterException, IOException {
        return new ResponseEntity<>(myPageService.getQrCode(accountEmail), HttpStatus.OK);
    }


    /**
     * 로그인 유저의 포인트 반환
     *
     * @param accountNo
     * @return Optional<Integer>
     * @throws Exception
     */
    @GetMapping("/myPoint/{accountNo}")
    public ResponseEntity<?> getPoint(@PathVariable Long accountNo) throws Exception{
        return new ResponseEntity<>(myPageService.getPoint(accountNo),HttpStatus.OK);
    }

    /**
     * 로그인 유저의 기부/수령 전체 목록 반환
     *
     * @param accountNo
     * @return Optional<JSONArray>
     * @throws Exception
     */
    @GetMapping("/allLog/{accountNo}")
    public ResponseEntity<?> getAllLog(@PathVariable Long accountNo) throws Exception{
        return new ResponseEntity<>(myPageService.getAllLog(accountNo),HttpStatus.OK);
    }

    /**
     * 로그인 유저의 기부 목록 반환
     *
     * @param accountNo
     * @return Optional<JSONArray>
     * @throws Exception
     */
    @GetMapping("/donate/{accountNo}")
    public ResponseEntity<?> getDonateLog(@PathVariable Long accountNo) throws Exception{
        return new ResponseEntity<>(myPageService.getDonateLog(accountNo),HttpStatus.OK);
    }

    /**
     * 로그인 유저의 수령 목록 반환
     *
     * @param receiverNo
     * @return Optional<JSONArray>
     * @throws Exception
     */
    @GetMapping("/receive/{receiverNo}")
    public ResponseEntity<?> getReceiveLog(@PathVariable Long receiverNo) throws Exception{
        return new ResponseEntity<>(myPageService.getReceiveLog(receiverNo),HttpStatus.OK);
    }

    /**
     * 로그인 유저의 책 찜 목록 반환
     *
     * @param accountNo
     * @return Optional<JSONArray>
     * @throws Exception
     */
    @GetMapping("/wishList/{accountNo}")
    public ResponseEntity<?> getWishList(@PathVariable Long accountNo) throws Exception{
        return new ResponseEntity<>(myPageService.getWishList(accountNo),HttpStatus.OK);
    }

    /**
     * 로그인 유저의 작성 게시글 목록 반환
     *
     * @param accountNo
     * @return Optional<JSONArray>
     * @throws Exception
     */
    @GetMapping("/myWrite/{accountNo}")
    public ResponseEntity<?> getBoardList(@PathVariable Long accountNo) throws Exception{
        return new ResponseEntity<>(myPageService.getBoardList(accountNo), HttpStatus.OK);
    }
}