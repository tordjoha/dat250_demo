package com.example.demo.controllers;

import com.example.demo.dm.PollManager;
import com.example.demo.dm.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/polls/{question}/vote")
public class VoteController {


}