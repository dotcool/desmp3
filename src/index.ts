import { registerPlugin } from '@capacitor/core';

import type { Desmp3Plugin } from './definitions';

const Desmp3 = registerPlugin<Desmp3Plugin>('Desmp3', {
  web: () => import('./web').then(m => new m.Desmp3Web()),
  
});

export * from './definitions';
export { Desmp3 };
