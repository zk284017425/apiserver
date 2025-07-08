

package org.zerock.apiserver.todo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.apiserver.todo.dto.ListDTO;
import org.zerock.apiserver.todo.dto.TodoDTO;
import org.zerock.apiserver.todo.service.TodoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/todos")
public class TodoAPIController {

  private final TodoService service;

  @GetMapping("{tno}")
  public TodoDTO getOne(@PathVariable("tno") Integer tno) {


    log.info("getOne...............");
    log.info(tno);
    
    return service.getOne(tno).get();
  }

  @PostMapping("")
  public TodoDTO register(TodoDTO dto) {

    log.info("register...............");
    log.info(dto);
      
    return service.register(dto);
  }
  
  @GetMapping("list")
  public ListDTO<TodoDTO> getList(@RequestParam("page") int page) {
      return service.list(page);
  }
  
  
}