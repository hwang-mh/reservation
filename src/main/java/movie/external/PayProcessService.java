
package movie.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by uengine on 2018. 11. 21..
 */

@FeignClient(name="pay", url="${api.url.payment}")
public interface PayProcessService {

    @RequestMapping(method= RequestMethod.GET, path="/payProcesses")
    public void pay(@RequestBody PayProcess payProcess);

}