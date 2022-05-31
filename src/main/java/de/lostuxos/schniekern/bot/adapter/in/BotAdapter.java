package de.lostuxos.schniekern.bot.adapter.in;

import de.lostuxos.schniekern.bot.adapter.in.params.CallRequest;
import de.lostuxos.schniekern.bot.adapter.in.params.Move;
import de.lostuxos.schniekern.bot.usecases.BotRegistry;
import de.lostuxos.schniekern.bot.usecases.params.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bot/")
public class BotAdapter {

    @Autowired
    private BotRegistry botRegistry;


    @PostMapping(path = "{botId}")
    @ResponseBody
    public Move call(@PathVariable("botId") String botId, @RequestBody CallRequest callRequest) {
        Call call = Call.builder()
                .opponent(callRequest.getOpponent())
                .roundId(callRequest.getOpponent())
                .build();

        var bot = botRegistry.findBotById(botId).orElseThrow(() -> new BotNotFoundException(botId));
        return bot.playRound(call);
    }

}
