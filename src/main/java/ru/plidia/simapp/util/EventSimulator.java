package ru.plidia.simapp.util;

import ru.plidia.simapp.entity.Gecko;

public class EventSimulator {

    public void StartSimulation(Gecko gecko) throws InterruptedException {
        while (checkStatusHealth(gecko)) {
            int event = (int) (Math.random() * 100);
            if (event >= 0 && event < 8) {
                eatCricketEvent(gecko);
            } else if (event >= 8 && event < 16) {
                eatCockroachEvent(gecko);
            } else if (event >= 16 && event < 22) {
                eatWormEvent(gecko);
            } else if (event >= 22 && event < 35) {
                protectTerritoryEvent(gecko);
            } else if (event >= 35 && event < 42) {
                sheddingEvent(gecko);
            } else if (event >= 42 && event < 52) {
                sleepEvent(gecko);
            } else if (event >= 52 && event < 65) {
                predatorAttackEvent(gecko);
            } else if (event >= 65 && event < 79) {
                LyingInTheSunEvent(gecko);
            } else if (event >= 79 && event < 85) {
                climbUpEvent(gecko);
            } else if (event >= 85 && event < 100) {
                hideEvent(gecko);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Геккон умер.");
    }

    private void eatCricketEvent(Gecko gecko) {
        int energy = gecko.getEnergy() - 8;
        int health = gecko.getHealth() + (int) (gecko.getNUTRICION() * 2);
        gecko.setEnergy(energy);
        gecko.setHealth(health);
        checkEnergy(gecko);
        correctionHealth(gecko);
        checkHealth(gecko);
        System.out.println("Геккон съел сверчка. Жирный сверчок, что может быть лучше? -8 энергии, +2 hp");
    }

    private void eatCockroachEvent(Gecko gecko) {
        int energy = gecko.getEnergy() - 8;
        int health = gecko.getHealth() + (int) (gecko.getNUTRICION() * 3);
        gecko.setEnergy(energy);
        gecko.setHealth(health);
        checkEnergy(gecko);
        correctionHealth(gecko);
        checkHealth(gecko);
        System.out.println("Геккон съел таракана. Без комментариев -_-. -8 энергии, +3 hp");
    }

    private void eatWormEvent(Gecko gecko) {
        int energy = gecko.getEnergy() - 4;
        int health = gecko.getHealth() + (int) (gecko.getNUTRICION() * 3);
        gecko.setEnergy(energy);
        gecko.setHealth(health);
        checkEnergy(gecko);
        correctionHealth(gecko);
        checkHealth(gecko);
        System.out.println("Геккон съел червя. Не очень приятно, зато как питательно! -4 энергии, +3 hp");
    }

    private void protectTerritoryEvent(Gecko gecko) {
        int energy = gecko.getEnergy() - 20;
        int health = gecko.getHealth() - 10;
        gecko.setEnergy(energy);
        gecko.setHealth(health);
        checkEnergy(gecko);
        correctionHealth(gecko);
        checkHealth(gecko);
        System.out.println("Геккон защищал свою территорию от других гекконов. Самые жирные сверчки живут под его кустом! -20 энергии, -10 hp");
    }

    private void sheddingEvent(Gecko gecko) {
        int energy = gecko.getEnergy() - 10;
        int health = gecko.getHealth() + 3;
        gecko.setEnergy(energy);
        gecko.setHealth(health);
        checkEnergy(gecko);
        correctionHealth(gecko);
        checkHealth(gecko);
        System.out.println("Геккон линяет. Что тут скажешь? Красота требует жертв. -5 энергии, +3 hp");
    }

    private void sleepEvent(Gecko gecko) {
        int energy = gecko.getEnergy() + 20;
        gecko.setEnergy(energy);
        checkEnergy(gecko);
        System.out.println("Геккон поспал. А кто бы не поспал? +20 энергии, уровень hp без изменения");
    }

    private void predatorAttackEvent(Gecko gecko) {
        int energy = gecko.getEnergy() - 15;
        int health = gecko.getHealth() - 10;
        gecko.setEnergy(energy);
        gecko.setHealth(health);
        checkEnergy(gecko);
        correctionHealth(gecko);
        checkHealth(gecko);
        System.out.println("На геккона напал хищник. Побежали! -10 энергии, -10 hp");
    }

    private void LyingInTheSunEvent(Gecko gecko) {
        int energy = gecko.getEnergy() + 10;
        gecko.setEnergy(energy);
        checkEnergy(gecko);
        System.out.println("Геккон погрелся на солнце. Да, гекконам тоже важен загар! +10 энергии, уровень hp без изменения");
    }

    private void climbUpEvent(Gecko gecko) {
        int energy = gecko.getEnergy() - 10;
        gecko.setEnergy(energy);
        checkEnergy(gecko);
        correctionHealth(gecko);
        checkHealth(gecko);
        System.out.println("Геккон залез повыше, может оттуда лучше видно? -10 энергии, уровень hp без изменения");
    }

    private void hideEvent(Gecko gecko) {
        int energy = gecko.getEnergy() - 5;
        gecko.setEnergy(energy);
        checkEnergy(gecko);
        correctionHealth(gecko);
        checkHealth(gecko);
        System.out.println("Геккон спрятался. Это только стратегическое отступление! -5 энергии, уровень hp без изменения");
    }

    private void correctionHealth(Gecko gecko) {
        int health = gecko.getHealth();
        if (gecko.getEnergy() == 0) {
            health = health - 10;
        }
        gecko.setHealth(health);
    }

    private void checkEnergy(Gecko gecko) {
        int energy = gecko.getEnergy();
        if (gecko.getEnergy() <= 0) {
            energy = 0;
        }
        if (gecko.getEnergy() >= 100) {
            energy = 100;
        }
        gecko.setEnergy(energy);
    }

    private void checkHealth(Gecko gecko) {
        int health = gecko.getHealth();
        if (gecko.getHealth() <= 0) {
            health = 0;
        }
        if (gecko.getHealth() >= 100) {
            health = 100;
        }
        gecko.setHealth(health);
    }

    private boolean checkStatusHealth(Gecko gecko) {
        System.out.println("energy: " + gecko.getEnergy() + " , hp: " + gecko.getHealth());
       return gecko.getHealth() > 0;
    }
}