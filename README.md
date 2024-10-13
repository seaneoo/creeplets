<!--suppress HtmlDeprecatedAttribute -->
<div align="center">
    <img src=".github/assets/banner.png" alt="Creeplets">
</div>

## Features

- **New Entity: Creeplet**
    - Variations from the standard Creeper:
        - **Fuse Time**: Reduced to 15 seconds.
        - **Explosion Radius**: Decreased to 2 blocks.
        - **Movement Speed**: Increased to 0.4.
        - **Max Health**: Decreased to 10.
    - **Drops**: 0-2 Unstable Gunpowder upon death.

- **New Item: Unstable Gunpowder**
    - Dropped by the Creeplet.
    - Used for crafting Unstable TNT.

- **New Block: Unstable TNT**
    - Crafted using Unstable Gunpowder.
        - Follows the same recipe as vanilla TNT, simply replace regular Gunpowder with Unstable Gunpowder.
    - **Coming Soon**: Will feature a random and configurable explosion size.

## Configuration

You can customize each attribute of the Creeplet by editing the configuration file located at `config/creeplets.json5`.

The default configuration is as follows:

```json5
{
  // The time it takes for the Creeplet to explode. Default of the vanilla Creeper is '30'.
  "fuseTime": 15,
  // The size of the explosion. Default of the vanilla Creeper is '3'.
  "explosionRadius": 2,
  // How fast the Creeplet moves. Default of the vanilla Creeper is '0.25'.
  "movementSpeed": 0.4,
  // The maximum health of the Creeplet. Default of the vanilla Creeper is '20'.
  "maxHealth": 10.0
}
```

## License

[MIT](LICENSE)
