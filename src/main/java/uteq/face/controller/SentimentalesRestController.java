package uteq.face.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import uteq.face.dao.ISentimentalesDao;
import uteq.face.model.SentimentalesModel;

@RestController
@RequestMapping("/SentimentalesRest")
public class SentimentalesRestController {

    @Autowired
    private ISentimentalesDao sentimentalesDao;

    @GetMapping
    public List<SentimentalesModel> list() {
        return sentimentalesDao.findAll();
    }

    @GetMapping("/{id}")
    public SentimentalesModel get(@PathVariable Long id) {
        return sentimentalesDao.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SentimentalesModel> put(@PathVariable Long id, @RequestBody SentimentalesModel sentimental) {

        SentimentalesModel sentimentalActual = sentimentalesDao.findById(id).orElse(null);

        if (sentimentalActual == null) {
            return new ResponseEntity<>(sentimentalActual, HttpStatus.NOT_FOUND);
        }

        sentimentalActual.setSentimental(sentimental.getSentimental());

        SentimentalesModel sentimentalActualizado = sentimentalesDao.save(sentimentalActual);
        HttpStatus generatedStatus = HttpStatus.CREATED;

        return new ResponseEntity<>(sentimentalActualizado, generatedStatus);
    }

    @PostMapping
    public ResponseEntity<SentimentalesModel> post(@RequestBody SentimentalesModel sentimental) {
        return new ResponseEntity<>(sentimentalesDao.save(sentimental), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        sentimentalesDao.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
 