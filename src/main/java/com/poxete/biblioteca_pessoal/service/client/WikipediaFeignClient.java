package com.poxete.biblioteca_pessoal.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "wikipedia-client", url = "${wikipedia.api.url}")
public interface WikipediaFeignClient {

    @GetMapping
    String search(@RequestParam("action") String action,
                  @RequestParam("list") String list,
                  @RequestParam("srsearch") String searchQuery,
                  @RequestParam("format") String format,
                  @RequestParam("origin") String origin);

    @GetMapping
    String getPageExtract(@RequestParam("action") String action,
                          @RequestParam("prop") String prop,
                          @RequestParam("exintro") boolean exintro,
                          @RequestParam("pageids") Integer pageId,
                          @RequestParam("format") String format,
                          @RequestParam("origin") String origin);

    @GetMapping
    String getPageDetails(@RequestParam("action") String action,
                          @RequestParam("prop") String prop,
                          @RequestParam("pageids") Integer pageid,
                          @RequestParam("format") String format,
                          @RequestParam("utf8") String utf8);
}
